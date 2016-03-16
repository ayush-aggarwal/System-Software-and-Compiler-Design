#include<stdio.h>
struct ptr
{
	int start,end;
}arr[15];
char* postfix(char regex[])
{
	int i,j,k,l=0;
	char op,*conregex;
	start1:
	for(i=0;regex[i]!=')';i++);
	for(j=i;regex[j]!='(';j--);
	for(k=j+1;k<i;k++)
		if(isalpha(regex[k]))
			conregex[l++]=regex[k];
		else if(regex[k]!='#')
			op=regex[k];
		conregex[l++]=op;
	for(k=j;k<=i;k++)
		regex[k]='#';
	if(regex[0]!='#')
		goto start1;
	conregex[l]='\0';
	return conregex;
}
void main()
{
	char regex[100],*postregex;
	int  ctr=0,node=0,prev1,prev2,beg,clo;
	printf("\nRegex:-  ");
	scanf("%s",regex);
	postregex=postfix(regex);
	printf("Converted Regex:- %s",postregex);
	printf("\n\tStart -----> End   on   INPUT\n");
	while(postregex[ctr]!='\0')
	{
		if(isalpha(postregex[ctr]))
		{
			arr[ctr].start=++node;
			arr[ctr].end=++node;
			printf("\n\t    %d -----> %d     on     %c",arr[ctr].start,arr[ctr].end,postregex[ctr]);
		}
		else
		{
			switch(postregex[ctr])
			{
				case '+':
					arr[ctr].start=++node;
					arr[ctr].end=++node;
					printf("\n\t    %d -----> %d     on     є",arr[ctr].start,arr[ctr-2].start);
					printf("\n\t    %d -----> %d     on     є",arr[ctr].start,arr[ctr-1].start);
					printf("\n\t    %d -----> %d     on     є",arr[ctr-2].end,arr[ctr].end);
					printf("\n\t    %d -----> %d     on     є",arr[ctr-1].end,arr[ctr].end);
					beg=arr[ctr].start;
					clo=arr[ctr].end;
				break;
				case '.':
					arr[ctr].end=arr[ctr-1].end;
					arr[ctr].start=arr[ctr-2].start;
					printf("\n\t    %d -----> %d     on     є",arr[ctr-2].end,arr[ctr-1].start);
					beg=arr[ctr-2].start;
					clo=arr[ctr-1].end;
				break;
				case '*':
					arr[ctr].start=++node;
					arr[ctr].end=++node;
					printf("\n\t    %d -----> %d     on     є",arr[ctr].start,arr[ctr-1].start);
					printf("\n\t    %d -----> %d     on     є",arr[ctr-1].end,arr[ctr].end);
					printf("\n\t    %d -----> %d     on     є",arr[ctr].start,arr[ctr].end);
					printf("\n\t    %d -----> %d     on     є",arr[ctr-1].end,arr[ctr-1].start);
					beg=arr[ctr].start;
					clo=arr[ctr].end;
				break;
			}
		}
	++ctr;	
	}
	printf("\nStarting State:- %d",beg);
	printf("\nClosing State:- %d",clo);	
}
