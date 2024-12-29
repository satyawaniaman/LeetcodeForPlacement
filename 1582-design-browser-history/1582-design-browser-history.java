class Node{
    public Node prev;
    public Node next;
    public String url;
    public Node(String url){
        this.url=url;
    } 
}
class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage){
        curr=new Node(homepage);
    }
    
    public void visit(String url) {
        curr.next=new Node(url);
        curr.next.prev=curr;
        curr=curr.next;
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps>0){
            curr=curr.prev;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps>0){
            curr=curr.next;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */