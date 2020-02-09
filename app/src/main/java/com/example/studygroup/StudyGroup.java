package com.example.studygroup;

import java.util.Date;
import java.util.List;

public class StudyGroup {

            private final int id;
            private final String faculty;
            private final String department;
            private final int year;
            private final int maxSize;
            private final List<String> initialModules;
            private final Date startDate;
            private final Date endDate;

            public StudyGroup(int id, String faculty, String department, int year, int maxSize, List<String> initialModules, Date startDate, Date endDate) {
                this.id = id;
                this.faculty = faculty;
                this.department = department;
                this.year = year;
        this.maxSize = maxSize;
        this.initialModules = initialModules;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<String> getInitialModules() {
        return initialModules;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
