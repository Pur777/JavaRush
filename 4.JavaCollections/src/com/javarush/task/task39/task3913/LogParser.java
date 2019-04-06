package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ip = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            ip.add(inEv.ip);
        }
        return ip;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ipForUser = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user)) {
                ipForUser.add(inEv.ip);
            }
        }
        return ipForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipForEvent = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(event)) {
                ipForEvent.add(inEv.ip);
            }
        }
        return ipForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipForStatus = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.status.equals(status)) {
                ipForStatus.add(inEv.ip);
            }
        }
        return ipForStatus;
    }

    private Set<InformationEvent> getSetConsiderDate(Date after, Date before) {
        Set<InformationEvent> ip = new HashSet<>();
        if (after == null && before == null) {
            ip.addAll(getAllInformationEvent(readLogs()));
        } else if (after == null) {
            for (InformationEvent inEv : getAllInformationEvent(readLogs())) {
                if (inEv.dateEvent.before(before)) {
                    ip.add(inEv);
                }
            }
        } else if (before == null) {
            for (InformationEvent inEv : getAllInformationEvent(readLogs())) {
                if (inEv.dateEvent.after(after)) {
                    ip.add(inEv);
                }
            }
        } else {
            for (InformationEvent inEv : getAllInformationEvent(readLogs())) {
                if (inEv.dateEvent.after(after) && inEv.dateEvent.before(before)) {
                    ip.add(inEv);
                }
            }
        }
        return ip;
    }

    private List<InformationEvent> getAllInformationEvent(List<String> list){
        List<InformationEvent> informationEventList = new ArrayList<>();
        for (String s : list) {
            informationEventList.add(getInfEve(s));
        }
        return informationEventList;
    }

    private List<String> readLogs() {
        List<String> logs = new ArrayList<>();
        try {
            List<Path> list = Files.walk(logDir).filter(Files::isRegularFile).collect(Collectors.toList());
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).toString().endsWith(".log")) {
                    list.remove(i);
                    i--;
                }
            }
            for (Path p : list) {
                try (BufferedReader reader = Files.newBufferedReader(p)) {
                    String s;
                    while ((s = reader.readLine()) != null) {
                        logs.add(s);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logs;
    }

    private InformationEvent getInfEve(String informationString) {
        InformationEvent aboutEvent;
        informationString = informationString.replaceAll("\t", " ");
        String[] elementString = informationString.split(" +");
        StringBuilder name = new StringBuilder();
        StringBuilder dateString = new StringBuilder();
        if (informationString.contains("DONE_TASK") || informationString.contains("SOLVE_TASK")) {
            int forName = elementString.length - 6;
            for (int i = 1; i <= forName; i++) {
                name.append(elementString[i]).append(" ");
            }
            name = new StringBuilder(name.toString().trim());

            int forDate = elementString.length - 5;
            for (int i = forDate; i < forDate + 2; i++) {
                dateString.append(elementString[i]).append(" ");
            }
            dateString = new StringBuilder(dateString.toString().trim());

            String ip = elementString[0];
            Date date = getDataEvent(dateString.toString());
            Event event = getEvent(elementString[elementString.length - 3]);
            int numbTask = Integer.parseInt(elementString[elementString.length - 2]);
            Status status = getStatus(elementString[elementString.length - 1]);

            aboutEvent = new InformationEvent(ip, name.toString(), date, event, numbTask, status);
        } else {
            int forName = elementString.length - 5;
            for (int i = 1; i <= forName; i++) {
                name.append(elementString[i]).append(" ");
            }
            name = new StringBuilder(name.toString().trim());

            int forDate = elementString.length - 4;
            for (int i = forDate; i < forDate + 2; i++) {
                dateString.append(elementString[i]).append(" ");
            }
            dateString = new StringBuilder(dateString.toString().trim());

            String ip = elementString[0];
            Date date = getDataEvent(dateString.toString());
            Event event = getEvent(elementString[elementString.length - 2]);
            int numbTask = 0;
            Status status = getStatus(elementString[elementString.length - 1]);

            aboutEvent = new InformationEvent(ip, name.toString(), date, event, numbTask, status);
        }

        return aboutEvent;
    }

    private Date getDataEvent(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date newDate = null;
        try {
            newDate = dateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    private Event getEvent(String event) {
        switch (event) {
            case "DONE_TASK":
                return Event.DONE_TASK;
            case "DOWNLOAD_PLUGIN":
                return Event.DOWNLOAD_PLUGIN;
            case "LOGIN":
                return Event.LOGIN;
            case "SOLVE_TASK":
                return Event.SOLVE_TASK;
            case "WRITE_MESSAGE":
                return Event.WRITE_MESSAGE;
            default:
                return null;
        }
    }

    private Status getStatus(String status) {
        switch (status) {
            case "OK":
                return Status.OK;
            case "FAILED":
                return Status.FAILED;
            case "ERROR":
                return Status.ERROR;
            default:
                return null;
        }
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getAllInformationEvent(readLogs())) {
            set.add(inEv.nameUser);
        }
        return set;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            set.add(inEv.nameUser);
        }
        return set.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<InformationEvent> list = new ArrayList<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user)) {
                list.add(inEv);
            }
        }
        list.sort(new Comparator<InformationEvent>() {
            @Override
            public int compare(InformationEvent o1, InformationEvent o2) {
                return o1.event.compareTo(o2.event);
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).event.equals(list.get(i + 1).event)) {
                list.remove(i);
                i--;
            }
        }
        return list.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.ip.equals(ip)) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.LOGIN)) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.DOWNLOAD_PLUGIN) && inEv.status.equals(Status.OK)) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.WRITE_MESSAGE) && inEv.status.equals(Status.OK)) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.SOLVE_TASK)) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.SOLVE_TASK) && inEv.numbTask == task) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.DONE_TASK)) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.DONE_TASK) && inEv.numbTask == task) {
                set.add(inEv.nameUser);
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user) && inEv.event.equals(event)) {
                set.add(inEv.dateEvent);
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.status.equals(Status.FAILED)) {
                set.add(inEv.dateEvent);
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.status.equals(Status.ERROR)) {
                set.add(inEv.dateEvent);
            }
        }
        return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<InformationEvent> list = new ArrayList<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user) && inEv.event.equals(Event.LOGIN)) {
                list.add(inEv);
            }
        }
        if (!list.isEmpty()) {
            list.sort(new Comparator<InformationEvent>() {
                @Override
                public int compare(InformationEvent o1, InformationEvent o2) {
                    return o1.dateEvent.compareTo(o2.dateEvent);
                }
            });
            return list.get(0).dateEvent;
        } else {
            return null;
        }
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<InformationEvent> list = new ArrayList<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user) && inEv.event.equals(Event.SOLVE_TASK) && inEv.numbTask == task) {
                list.add(inEv);
            }
        }
        if (!list.isEmpty()) {
            list.sort(new Comparator<InformationEvent>() {
                @Override
                public int compare(InformationEvent o1, InformationEvent o2) {
                    return o1.dateEvent.compareTo(o2.dateEvent);
                }
            });
            return list.get(0).dateEvent;
        } else {
            return null;
        }
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<InformationEvent> list = new ArrayList<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user) && inEv.event.equals(Event.DONE_TASK) && inEv.numbTask == task) {
                list.add(inEv);
            }
        }
        if (!list.isEmpty()) {
            list.sort(new Comparator<InformationEvent>() {
                @Override
                public int compare(InformationEvent o1, InformationEvent o2) {
                    return o1.dateEvent.compareTo(o2.dateEvent);
                }
            });
            return list.get(0).dateEvent;
        } else {
            return null;
        }
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user) && inEv.event.equals(Event.WRITE_MESSAGE)) {
                set.add(inEv.dateEvent);
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user) && inEv.event.equals(Event.DOWNLOAD_PLUGIN)) {
                set.add(inEv.dateEvent);
            }
        }
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            set.add(inEv.event);
        }
        return set.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            set.add(inEv.event);
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.ip.equals(ip)) {
                set.add(inEv.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.nameUser.equals(user)) {
                set.add(inEv.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.status.equals(Status.FAILED)) {
                set.add(inEv.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.status.equals(Status.ERROR)) {
                set.add(inEv.event);
            }
        }
        return set;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.SOLVE_TASK) && inEv.numbTask == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.DONE_TASK) && inEv.numbTask == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Set<Integer> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.SOLVE_TASK)) {
                set.add(inEv.numbTask);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : set) {
            map.put(i, getNumberOfAttemptToSolveTask(i, after, before));
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Set<Integer> set = new HashSet<>();
        for (InformationEvent inEv : getSetConsiderDate(after, before)) {
            if (inEv.event.equals(Event.DONE_TASK)) {
                set.add(inEv.numbTask);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : set) {
            map.put(i, getNumberOfSuccessfulAttemptToSolveTask(i, after, before));
        }
        return map;
    }

    private Set<InformationEvent> filterInformationEvent(Request request) {
        if (request.forWhat == null) {
            return new HashSet<>(getAllInformationEvent(readLogs()));
        } else if (request.forWhat.equals("ip")) {
            return filterInformationEvent(request.value, request.after, request.before);
        } else if (request.forWhat.equals("user")) {
            return filterInformationEvent(request.after, request.before, request.value);
        } else if (request.forWhat.equals("date")) {
            return filterInformationEvent(getDataEvent(request.value), request.after, request.before);
        } else if (request.forWhat.equals("event")) {
            return filterInformationEvent(getEvent(request.value), request.after, request.before);
        } else if (request.forWhat.equals("status")) {
            return filterInformationEvent(getStatus(request.value), request.after, request.before);
        } else {
            return new HashSet<>();
        }
    }

    private Set<InformationEvent> filterInformationEvent(String ip, Date after, Date before) {
        Set<InformationEvent> set = new HashSet<>();
        for (InformationEvent informationEvent : getSetConsiderDate(after, before)) {
            if (informationEvent.ip.equals(ip)) {
                set.add(informationEvent);
            }
        }
        return set;
    }

    private Set<InformationEvent> filterInformationEvent(Date after, Date before, String user) {
        Set<InformationEvent> set = new HashSet<>();
        for (InformationEvent informationEvent : getSetConsiderDate(after, before)) {
            if (informationEvent.nameUser.equals(user)) {
                set.add(informationEvent);
            }
        }
        return set;
    }

    private Set<InformationEvent> filterInformationEvent(Event event, Date after, Date before) {
        Set<InformationEvent> set = new HashSet<>();
        for (InformationEvent informationEvent : getSetConsiderDate(after, before)) {
            if (informationEvent.event.equals(event)) {
                set.add(informationEvent);
            }
        }
        return set;
    }

    private Set<InformationEvent> filterInformationEvent(Status status, Date after, Date before) {
        Set<InformationEvent> set = new HashSet<>();
        for (InformationEvent informationEvent : getSetConsiderDate(after, before)) {
            if (informationEvent.status.equals(status)) {
                set.add(informationEvent);
            }
        }
        return set;
    }

    private Set<InformationEvent> filterInformationEvent(Date date, Date after, Date before) {
        Set<InformationEvent> set = new HashSet<>();
        for (InformationEvent informationEvent : getSetConsiderDate(after, before)) {
            if (informationEvent.dateEvent.equals(date)) {
                set.add(informationEvent);
            }
        }
        return set;
    }

    private Set<String> getIps(Set<InformationEvent> informationEventSet){
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : informationEventSet) {
            set.add(inEv.ip);
        }
        return set;
    }
    private Set<String> getUsers(Set<InformationEvent> informationEventSet){
        Set<String> set = new HashSet<>();
        for (InformationEvent inEv : informationEventSet) {
            set.add(inEv.nameUser);
        }
        return set;
    }
    private Set<Date> getDates(Set<InformationEvent> informationEventSet){
        Set<Date> set = new HashSet<>();
        for (InformationEvent inEv : informationEventSet) {
            set.add(inEv.dateEvent);
        }
        return set;
    }
    private Set<Event> getEvents(Set<InformationEvent> informationEventSet){
        Set<Event> set = new HashSet<>();
        for (InformationEvent inEv : informationEventSet) {
            set.add(inEv.event);
        }
        return set;
    }
    private Set<Status> getStatuses(Set<InformationEvent> informationEventSet){
        Set<Status> set = new HashSet<>();
        for (InformationEvent inEv : informationEventSet) {
            set.add(inEv.status);
        }
        return set;
    }
    @Override
    public Set<Object> execute(String query) {
        Set set = new HashSet();
        Request request = new Request(query);
        switch (request.whatNeed) {
            case "ip":
                set = getIps(filterInformationEvent(request));
                return set;
            case "user":
                set = getUsers(filterInformationEvent(request));
                return set;
            case "date":
                set = getDates(filterInformationEvent(request));
                return set;
            case "event":
                set = getEvents(filterInformationEvent(request));
                return set;
            case "status":
                set = getStatuses(filterInformationEvent(request));
                return set;
            default:
                return set;
        }
    }

    public class InformationEvent {
        String ip;
        String nameUser;
        Date dateEvent;
        Event event;
        int numbTask;
        Status status;

        InformationEvent(String ip, String nameUser, Date dateEvent, Event event, int numbTask, Status status) {
            this.ip = ip;
            this.nameUser = nameUser;
            this.dateEvent = dateEvent;
            this.event = event;
            this.numbTask = numbTask;
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof InformationEvent)) return false;
            InformationEvent that = (InformationEvent) o;
            return numbTask == that.numbTask &&
                    ip.equals(that.ip) &&
                    nameUser.equals(that.nameUser) &&
                    dateEvent.equals(that.dateEvent) &&
                    event == that.event &&
                    status == that.status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ip, nameUser, dateEvent, event, numbTask, status);
        }
    }

    public class Request {
        String whatNeed;
        String forWhat;
        String value;
        Date after;
        Date before;

        Request(String string) {
            int occurrencesCount = string.length() - string.replace("\"", "").length();
            String[] s;
            switch (occurrencesCount) {
                case 0:
                    s = string.split(" +");
                    whatNeed = s[1];
                    break;
                case 2:
                    s = string.split(" +");
                    whatNeed = s[1];
                    forWhat = s[3];
                    s = string.split("\"");
                    value = s[1];
                    break;
                case 6:
                    s = string.split(" +");
                    whatNeed = s[1];
                    forWhat = s[3];
                    s = string.split("\"");
                    value = s[1];
                    after = getDataEvent(s[3]);
                    before = getDataEvent(s[5]);
            }
        }
    }
}