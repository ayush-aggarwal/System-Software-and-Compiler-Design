#include<stdio.h>
struct node
{
	int start,end;
}arr[15];
char *postfix(char str[])
{
	int i,j,k,l=0;
	char *temp,op;
	start:
	for(i=0;str[i]!=')';i++);
	for(j=i;str[j]!='(';j--);
	for(k=j+1;k<i;k++)
	{
		if(isalpha(str[k]))
			temp[l++]=str[k];
		else 
			op=str[k];
	}
	temp[l++]=op;
	for(k=j;k<=i;k++)
		str[k]='#';
	if(str[0]!='#')
		goto start;
	else
		temp[l]='\0';
	return temp;
}
void main()
{
	char *postregex;
	char regex[15];
	int i=0,n=0,no=0,beg=0,clo=0;
	printf("\nEnter Regex:- ");
	scanf("%s",regex);
	postregex=postfix(regex);
	printf("\nPostfix Expression:- %s\n",postregex);
	printf("START----------------->END    on   INPUT\n");
	while(postregex[i]!='\0')
	{
		if(isalpha(postregex[i]))
		{
			arr[i].start=++no;
			arr[i].end=++no;
			printf("  %d  -----------------> %d     on   %c\n",arr[i].start,arr[i].end,postregex[i]);
		}
		else
		{
			switch(postregex[i])
			{
			case '+':
				arr[i].start=++no;
				arr[i].end=++no;
				if(clo==0)
				{
					if(beg==0)
						beg=arr[i].start;
					clo=arr[i].end;
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,arr[i-2].start,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,arr[i-1].start,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i-2].end,arr[i].end,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i-1].end,arr[i].end,"Ɛ");
				}
				else
				{
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,beg,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,arr[i-1].start,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i-1].end,arr[i].end,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",clo,arr[i].end,"Ɛ");
					beg=arr[i].start;
					clo=arr[i].end;
				}
				break;
			case '.':
				if(clo==0)
				{
					printf("  %d  -----------------> %d     on   %s\n",arr[i-2].end,arr[i-1].start,"Ɛ");
					clo=arr[i-1].end;
					if(beg==0)
						beg=arr[i-2].start;
				}
				else
				{
					printf("  %d  -----------------> %d     on   %s\n",clo,arr[i-1].start,"Ɛ");
					clo=arr[i-1].end;
				}
				break;
			case '*':
				arr[i].start=++no;
				arr[i].end=++no;
				if(clo==0)
				{
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,arr[i-1].start,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,arr[i].end,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i-1].end,arr[i-1].start,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i-1].end,arr[i].end,"Ɛ");
					beg=arr[i].start;
					clo=arr[i].end;
				}
				else
				{
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,beg,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",clo,beg,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",clo,arr[i].end,"Ɛ");
					printf("  %d  -----------------> %d     on   %s\n",arr[i].start,arr[i].end,"Ɛ");
					beg=arr[i].start;
					clo=arr[i].end;
				}
				break;
			}
		}
		++i;
	}
	printf("\nStart State:- %d",beg);
	printf("\nEnd State:- %d\n",clo);
}	
