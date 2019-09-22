/*
Nikita Heinonen, 9109071952, nikitah@kth.se
*/

#include <stdio.h>
#include <stdbool.h>

void setClock(int c);
void setAlarm(int a);
void updateHour();			
void updateMinute();
void updateSecond();
bool compareClock(int h, int m, int s, int ah, int am, int as);
int getHour();
int getMinute();
int getSecond();
void delay();
void edgeSecond();
void edgeMinute();
void edgeHour();
int concatenate(int x, int y);
void runTime();

int present_time, time_for_alarm, hour, minute, second, alarmHour, alarmMinute, alarmSecond;
int MAX_HOUR = 23;
int MAX_MINUTE = 59;
int MAX_SECOND = 59;
int arrayClock[6], arrayAlarm[6];


int main()
{
	printf("Ange tid som klockan startar på formen HHMMSS:\n");
	scanf("%d", &present_time);
	printf("Ange tid då larmet ska gå formen HHMMSS:\n");
	scanf("%d", &time_for_alarm);
	setClock(present_time);
	setAlarm(time_for_alarm);
	runTime();
}
//kör själva klockan. Uppdaterar minut och sekund och timme om det hamnar över gränsen,
//så som minut 59, timme 23 osv.
void runTime(){
	while(!compareClock(hour, minute, second, alarmHour, alarmMinute, alarmSecond)){
		printf("%d:%d:%d\n", hour, minute, second);
		delay();
		if(second == 59){
			updateMinute();
		}
		if(minute == 0 && second == 59){
			updateHour();
		}
		updateSecond();
	}
	printf("%d:%d:%d\n", hour, minute, second);	
	printf("ALARM!\n");
}
//Jämför nuvarande klockslag med tiden då alarmet ska gå
bool compareClock(int h, int m, int s, int ah, int am, int as){
	if(h == ah && m == am && s == as)
		return 1;
	else
		return 0;
}
//samma som för klockan fast för larmet
void setAlarm(int a){
	int count = 0;
	while(a > 0){
		int temp = a % 10;
		arrayAlarm[count] = temp;
		a /= 10;
		count++;
	}
	alarmSecond = concatenate(arrayAlarm[1], arrayAlarm[0]);
	alarmMinute = concatenate(arrayAlarm[3], arrayAlarm[2]);
	alarmHour = concatenate(arrayAlarm[5], arrayAlarm[4]);
}

void edgeSecond(){
	if(getSecond() > MAX_SECOND){
		second = concatenate(0, 0);
	}
}

void edgeMinute(){
	if(getMinute() > MAX_MINUTE){
		minute = concatenate(0, 0);
	}
}

void edgeHour(){
	if(getHour() > MAX_HOUR){
		hour = concatenate(0, 0);
	}
}

//Delar upp det initiala klocktalet och lägger in respektive siffra i en array
//tilldelar sedan rätt värde till timme,minut och sekund
void setClock(int c){
	int count = 0;
	while(c > 0){
		int temp = c % 10;
		arrayClock[count] = temp;
		c /= 10;
		count++;
	}
	second = concatenate(arrayClock[1], arrayClock[0]);
	minute = concatenate(arrayClock[3], arrayClock[2]);
	hour = concatenate(arrayClock[5], arrayClock[4]);
}

//Sätter ihop två tal till ett, t.ex. x=2, y=3 blir 23.
int concatenate(int x, int y){
	int pow = 10;
	while(y >= pow){
		pow *= 10;
	}
	return x * pow + y;
}


void updateHour(){
	hour++;
	edgeHour();
}

void updateMinute(){
	minute++;
	edgeMinute();
}

void updateSecond(){
	second++;
	edgeSecond();
}

int getHour(){
	return hour;
}

int getMinute(){
	return minute;
}

int getSecond(){
	return second;
}


//Delay för att simulera en sekunds tick
void delay(){
	for(int i = 0; i < 350000000; i++){}
}
