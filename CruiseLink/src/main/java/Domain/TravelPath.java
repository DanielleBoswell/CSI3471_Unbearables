package Domain;

/** Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: TravelPath.java
 * Creation Date: 10/15/2023
 * Modified Date: 10/18/2023
 * Description: Contains the travel path of Ship
 * @Author Danielle Boswell
 *
 */

import java.sql.Date;
import java.util.Map;
import java.util.TreeMap;

public class TravelPath {
    private int days = 0;
    private Date startDate = null;
    private Date endDate = null;
    private Map<Date, Country> path = null;

    /**
     * constructor for TravelPath
     */
    public TravelPath(){

    }


    /**
     * gets number of days of Travel Path
     *
     * @return days of travel
     */
    public int getDays() {
        return days;
    }

    /**
     * sets number of days of Travel Path
     *
     * @param
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * gets the start date of Travel Path
     *
     * @return Date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * sets the start date of Travel Path
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * gets the end date of Travel Path
     *
     * @return Date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * sets the end date of Travel Path
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * gets the path of the Travel Path
     *
     * @return Date
     */
    public Map<Date,Country> getPath() {
        return path;
    }

    /**
     * sets the path of the Travel Path
     * @param path
     */
    public void setPath(Map<Date,Country> path) {
        this.path = path;
    }

    /**
     * adds a Country to the Travel Path
     * @param c
     */
    public void addCountry(Country c) {
        if(path == null) {
            path = new TreeMap<Date,Country>();
        }

        if(!path.containsKey(c.getArrivalDate())) {
            path.put(c.getArrivalDate(),c);
            if(days == 0) {
                startDate = c.getArrivalDate();
                endDate = c.getDepartureDate();
            }
            else {
                if(startDate.after(c.getArrivalDate())) startDate = c.getArrivalDate();
                else if(endDate.before(c.getDepartureDate())) endDate = c.getDepartureDate();
            }
            days++;
        }
    }

    /**
     * finds if the Travel Path is at a stop at a startDate and
     * returns the Country of the stop if so
     * @param date
     * @return
     */
    public Country checkStartDate(Date date) {
        Country temp = null;
        if(!date.equals(endDate)) { // makes sure guest not registering for last day
            if(path.containsKey(date)) {
                temp = path.get(date);
            }
            else {
                for(Map.Entry<Date,Country> y : path.entrySet()) {
                    if(date.after(y.getKey()) && date.before(y.getValue().getDepartureDate())) {
                        temp = y.getValue();
                    }
                }
            }
        }

        return temp;
    }

    /**
     * finds if the Travel Path is at a stop at a endDate and
     * returns the Country of the stop if so
     * @param date
     * @return
     */
    public Country checkEndDate(Date date) {
        Country temp = null;
        if(!date.equals(startDate)) { // makes sure guest not registering for first day
            if(path.containsKey(date)) {
                temp = path.get(date);
            }
            else {
                for(Map.Entry<Date,Country> y : path.entrySet()) {
                    if(date.after(y.getKey()) && date.before(y.getValue().getDepartureDate())) {
                        temp = y.getValue();
                    }
                }
            }
        }

        return temp;
    }

    /**
     * finds if a range of days between a start and end date
     * is valid according to the Travel Path stops
     * @param start, end
     * @return
     */
    public boolean checkDates(Date start, Date end) {
        if(checkEndDate(end) != null && checkStartDate(start) != null) {
            return true;
        }
        else {
            return false;
        }
    }



}