#include<stdio.h>
#include<ctype.h>
#include<malloc.h>
struct ptr
{
	char d;
	struct ptr *next;
};
struct node
{
	int x;
	struct ptr *p;
};
int main()
{
	struct ptr *start=NULL;
	int i,p=0,q=0,j,nodecount=1,z=0;
	char t,a1,a2;
	char regex[100];
	char letters[100];
	char operators[100];
	printf("\nPlease Enter the Regular Expression:- ");
	scanf("%s",regex);
	for(i=0;regex[i]!='\0';i++)
	{
		if(isalpha(regex[i]))
			letters[p++]=regex[i];
		else
			operators[q++]=regex[i];
	}
	for(j=0;j<q;j++)
	{
		t=operators[j];
		if(t=='.')
		{
			struct node *n1=(struct node*)malloc(sizeof(struct node));
			n1->x=nodecount;
			nodecount=nodecount+1;
			n1->p->d=letters[a1];
			a1++;
			struct node *n2=(struct node*)malloc(sizeof(struct node));
			n2->x=nodecount;
			nodecount=nodecount+1;
			n1->p->next=n2;
			n2->p->d='E';
			struct node *n3=(struct node*)malloc(sizeof(struct node));
			n3->x=nodecount;
			nodecount=nodecount+1;
			n2->p->next=n3;
			n3->p->d=letters[a1];
			a1++;
			struct node *n4=(struct node*)malloc(sizeof(struct node));
			n4->x=nodecount;
			nodecount=nodecount+1;
			n3->p->next=n4;
			printf("shaghgfhd\n");
		}
	}
	return 0;
}

