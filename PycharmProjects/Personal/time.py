# I want a program that can read the current time
# From this, it can calculate all of the best times for me to wake up
# It should have multiple settings - If I went to bed now, when you plan to goto bed. (When you want to wake up later)
# It should have a GUI to show the times

# So far I have implemented everything but a gui.


from datetime import datetime, timedelta


def main():
    print("Hello and welcome to the alarm program. Please select an option:")
    while True:
        print("(1) - If I went to bed now, what time should I wake up?")
        print("(2) - If I plan to goto bed at a certain time, what time should I wake up?")
        print("(3) - If I have to wave up at a certain time, what time should I sleep?")
        print("(4) - Exit program")

        option = get_int_input()

        if option == 1:
            bed_now()
        elif option == 2:
            bed_when()
        elif option == 3:
            wake_when()
        elif option == 4:
            break
        else:
            print("Invalid input, returning to menu")


def bed_now():
    curr_time = datetime.now()
    first_sleep = curr_time + timedelta(hours=1, minutes=44)
    print("If you were to sleep now, it is recommended for you to set your alarm for:")
    sleep_array(first_sleep, 1)


def bed_when():
    sleep_time = get_time_input()
    formatted_sleep_time = sleep_time.strftime("%H:%M")
    print(f"If you were to sleep at {formatted_sleep_time}, it is recommended you set your alarm for:")
    sleep_array(sleep_time, 1)


def wake_when():
    wake_time = get_time_input()
    formatted_wake_time = wake_time.strftime("%H:%M")
    print(f"If you were to wake at {formatted_wake_time}, it is recommended you sleep at:")
    sleep_array(wake_time, -1)


def sleep_array(start_time, sign):
    time_array = [(start_time + i * sign * timedelta(hours=1, minutes=30)).strftime("%H:%M") for i in range(1, 7)]
    for time in time_array:
        print(f"- {time}")


def get_int_input():
    while True:
        try:
            option = int(input())
            break
        except ValueError:
            print("Invalid input, be sure to input an integer below 3")
    return option


def get_time_input():
    while True:
        try:
            input_time = str(input("Using 24 hour time, enter when you plan to fall asleep in the format H:M\n"))
            formatted_time = datetime.strptime(input_time, '%H:%M')
            break

        except ValueError:
            print("Error, try entering the time again")
    return formatted_time


if __name__ == '__main__':
    main()
