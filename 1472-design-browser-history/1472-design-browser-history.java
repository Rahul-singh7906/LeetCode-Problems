class BrowserHistory {
    List<String> list;
    int curr=0;
    int total=0;
    public BrowserHistory(String homepage) {
        list=new ArrayList<>();
        list.add(homepage);
        curr++;
        total++;
    }
    
    public void visit(String url) {
        if (list.size() > curr) {
            list.set(curr, url);
        } else {
            list.add(url);
        }
        curr++;
        total = curr;
    }

    public String back(int steps) {
        curr = Math.max(1, curr - steps);
        return list.get(curr - 1);
    }

    public String forward(int steps) {
        curr = Math.min(total, curr + steps);
        return list.get(curr - 1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */