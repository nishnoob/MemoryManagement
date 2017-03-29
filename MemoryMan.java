package MemoryMan;

import java.util.Scanner;

/**
 * Created by agnish on 8/3/17.
 */

//The Node Structure
class Link{
    public int pId;
    public int mSize;
    public int startAdd;
    public int endAdd;
    public Link nextLink = null;
}

class LinkList{
    private Link head;
    private static final int startMIN = 0;
    private static final int endMAX = 2000;

    public LinkList(){
        Link link1 = new Link();
        Link link2 = new Link();
        Link link3 = new Link();
        Link link4 = new Link();
        
        link1.mSize = 395;
        link1.startAdd = 200;
        link1.endAdd = 595;
        link1.pId = 1;
        
        link2.mSize = 100;
        link2.startAdd = 630;
        link2.endAdd = 730;
        link2.pId = 2;
        
        link4.mSize = 400;
        link4.startAdd = 770;
        link4.endAdd = 1170;
        link4.pId = 3;
        
        link3.mSize = 260;
        link3.startAdd = 1220;
        link3.endAdd = 1480;
        link3.pId = 4;
        
        head = link1;
        link1.nextLink = link2;
        link2.nextLink = link4;
        link4.nextLink = link3;
        link3.nextLink = null;
    }

    public void insertFF(){
        Link temp = head;
        Link link = new Link();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the process (Not more than 2000!):");
        link.mSize = sc.nextInt();
        System.out.println("Enter the Process ID:");
        link.pId = sc.nextInt();
        
        if(head == null){
            link.startAdd = 0;
            link.endAdd = link.mSize;
            link.nextLink = null;
            head = link;
            System.out.println("Data Allocated!");
        }
        
        else{
            while(temp.nextLink != null){
                if((temp.nextLink.startAdd - temp.endAdd) >= link.mSize){
                    link.nextLink = temp.nextLink;
                    link.startAdd = temp.endAdd + 1;
                    link.endAdd = temp.endAdd + link.mSize +1;
                    temp.nextLink = link;
                    System.out.println("Data Allocated!");
                    return;
                }
                temp = temp.nextLink;
            }

            if(temp.nextLink == null && ((temp.endAdd+link.mSize) <= endMAX)){
                temp.nextLink = link;
                link.startAdd = temp.endAdd + 1;
                link.endAdd = temp.endAdd + link.mSize +1;
                link.nextLink = null;
                System.out.println("Data Allocated!");
            }

            else{
                System.out.println("Space not available!");
            }
        }
    }
    
    public int searchBF(Link nd){
        Link temp = head;
        int val = 10000;
        
        while(temp.nextLink != null){
            if(val>(temp.nextLink.startAdd - temp.endAdd) && (temp.nextLink.startAdd - temp.endAdd) >= nd.mSize)
                val = temp.nextLink.startAdd - temp.endAdd;
            temp = temp.nextLink;
        }
        
        if(( endMAX - temp.endAdd ) < val && ( endMAX - temp.endAdd ) >= nd.mSize )
            val = endMAX - temp.endAdd;
        
        return val;
    }
    
    public void insertBF(){
        Link temp = head;
        Link link = new Link();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Process (Not more than 2000!):");
        link.mSize = sc.nextInt();
        System.out.println("Enter the Process ID:");
        link.pId = sc.nextInt();
        int val = searchBF(link);
        
        if(head == null){
            link.startAdd = 0;
            link.endAdd = link.mSize;
            link.nextLink = null;
            head = link;
            System.out.println("Data Allocated!");
        }
        
        else{
            while(temp.nextLink != null){
                if((temp.nextLink.startAdd - temp.endAdd) == val){
                    link.nextLink = temp.nextLink;
                    link.startAdd = temp.endAdd + 1;
                    link.endAdd = temp.endAdd + link.mSize +1;
                    temp.nextLink = link;
                    System.out.println("Data Allocated!");
                    return;
                }
                temp = temp.nextLink;
            }

            if(temp.nextLink == null && (temp.nextLink.startAdd - temp.endAdd) == val){
                temp.nextLink = link;
                link.startAdd = temp.endAdd + 1;
                link.endAdd = temp.endAdd + link.mSize +1;
                link.nextLink = null;
                System.out.println("Data Allocated!");
            }

            else{
                System.out.println("Space not available!");
            }
        }
    }
    
    public int searchWF(Link nd){
        Link temp = head;
        int val = 0;
        
        while(temp.nextLink!=null){
            if(val<(temp.nextLink.startAdd - temp.endAdd) && (temp.nextLink.startAdd - temp.endAdd) >= nd.mSize)
                val = temp.nextLink.startAdd - temp.endAdd;
            temp = temp.nextLink;
        }
        
        if((endMAX - temp.endAdd) > val && (endMAX - temp.endAdd) >= nd.mSize)
            val = endMAX - temp.endAdd;
        
        return val;
    }
    
    public void insertWF(){
        Link temp = head;
        Link link = new Link();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Process (Not more than 2000!):");
        link.mSize = sc.nextInt();
        System.out.println("Enter the Process ID:");
        link.pId = sc.nextInt();
        int val = searchWF(link);
        
        if(head == null){
            link.startAdd = 0;
            link.endAdd = link.mSize;
            link.nextLink = null;
            head = link;
            System.out.println("Data Allocated!");
        }
        
        else{
            while(temp.nextLink != null){
                if((temp.nextLink.startAdd - temp.endAdd) == val){
                    link.nextLink = temp.nextLink;
                    link.startAdd = temp.endAdd + 1;
                    link.endAdd = temp.endAdd + link.mSize +1;
                    temp.nextLink = link;
                    System.out.println("Data Allocated!");
                    return;
                }
                temp = temp.nextLink;
            }

            if(temp.nextLink == null && (endMAX - temp.endAdd) == val){
                temp.nextLink = link;
                link.startAdd = temp.endAdd + 1;
                link.endAdd = temp.endAdd + link.mSize +1;
                link.nextLink = null;
                System.out.println("Data Allocated!");
            }

            else{
                System.out.println("Space not available!");
            }
        }
    }

    public void printLL(){
        Link temp = head;
        while(temp != null){
            System.out.println("----------------------");
            System.out.println("Process ID: " + temp.pId);
            System.out.println("Start Address of process: " + temp.startAdd);
            System.out.println("End Address of process: " + temp.endAdd);
            System.out.println("----------------------");
            System.out.println();
            temp = temp.nextLink;
            
        }
    }
    
    public void pIdCheck( Link link){
        int ino;
        Link temp = head;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the Process ID to be deleted:");
        ino = sc.nextInt();
        while(temp!=null){
            if(temp.pId == ino){
                return;
            }
            else{
                link.pId = ino;
                return;
                
            }
        }
    }
    
    public void deleteLL(){
        Link temp = head;
        Link prev = null;
        
        while(temp.nextLink != null){
            if(temp.pId == ino){
                if(prev == null){
                    head = temp.nextLink;
                    return;
                }
                prev.nextLink = temp.nextLink;
                return;
            }
            
            prev = temp;
            temp = temp.nextLink;
            prev.nextLink = temp;
        }
    }
}

public class MemoryMan {
    public static void main(String[] args){
        int ip = 20;
        LinkList newLL = new LinkList();
        Scanner sc = new Scanner(System.in);

        while(ip!=0){
            System.out.println("------------------");
            System.out.println("Choose an option:");
            System.out.println("Add segment :-");
            System.out.println("    1. First-Fit");
            System.out.println("    2. Best-Fit");
            System.out.println("    3. Worst-Fit");
            System.out.println();
            System.out.println("4. Print segments.");
            System.out.println("5. Delete segments.");
            System.out.println("0. Terminate.");
            System.out.println("------------------");
            System.out.println("Your option:");
            ip = sc.nextInt();
            
            switch(ip){
                case 1: newLL.insertFF(); break;
                case 2: newLL.insertBF(); break;
                case 3: newLL.insertWF(); break;
                case 4: newLL.printLL(); break;
                case 5: newLL.deleteLL(); break;
                default: System.out.println("Wrong Input!");
            }
            
            System.out.println("In order to terminate press 0:");
            ip = sc.nextInt();
            if(ip!=0)
                continue;
        }
    }
}
