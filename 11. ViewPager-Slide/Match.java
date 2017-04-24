package com.matchslide.model;

public class Match {

    private String teamOne;
    private String teamTwo;
    private String time;
    private String channel;

    public Match() {
    }

    public Match(String teamOne, String teamTwo, String time, String channel) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.time = time;
        this.channel = channel;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
