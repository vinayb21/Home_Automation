from datetime import datetime
from datetime import date
import calendar


def findDate():
    my_date = date.today()
    weekday = calendar.day_name[my_date.weekday()]


    if weekday == "Monday":
        weekday =  1
    if weekday == "Tuesday":
        weekday =  2
    if weekday == "Wednesday":
        weekday =  3
    if weekday == "Thursday":
        weekday =  4
    if weekday == "Friday":
        weekday =  5
    if weekday == "Saturday":
        weekday =  6
    if weekday == "Sunday":
        weekday =  0
    
    
    currentSecond= datetime.now().second
    currentMinute = datetime.now().minute
    currentHour = datetime.now().hour

    currentDay = datetime.now().day
    currentMonth = datetime.now().month
    #currentYear = datetime.now().year
    return currentHour,currentMinute,currentSecond,currentDay,currentMonth,weekday
    
