#include<stdio.h>
#include<ctype.h>
#include<malloc.h>
struct node
{
	int x;
	char d;
	struct node *next[5];
}*start,*rear;
struct node* create_new_node(int m,char n)
{
	struct node *n1=malloc(sizeof(struct node));
	n1->x=m;
	n1->d=n;
	n1->next[0]=NULL;
	return n1;
}
void display(struct node *n)
{
	while(n!=NULL)
	{
		printf("%d on %c -> ",n->x,n->d);
		n=n->next[0];
	}
}
int insert(struct node* np)
{
	if(start==NULL)
	{
		start=rear=np;
	}
	else
	{
		rear->next[0]=np;
		rear=np;
	}
	return 0;
}
int main()
{
	int i,p=0,q=0,j,nodecount=1,z=0,a1=0;
	start=rear=NULL;
	char t,a2;
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
			struct node *np;
			np=create_new_node(nodecount,letters[a1]);
			nodecount++;
			a1++;
			insert(np);
			np=create_new_node(nodecount,(char)'E');
			nodecount++;
			insert(np);
			np=create_new_node(nodecount,letters[a1]);
			nodecount++;
			a1++;
			insert(np);
			np=create_new_node(nodecount,']');
			nodecount++;
			insert(np);
			display(start);
		}
		else if(t=='+')
		{
			struct node *np;
		}
		else if(t=='*')
		{
			
	}
	return 0;
}

