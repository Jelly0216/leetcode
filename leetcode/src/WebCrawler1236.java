public class WebCrawler1236 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        String hostName = getHost(startUrl);
        queue.offer(startUrl);
        visited.add(startUrl);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currUrl = queue.poll();
                res.add(currUrl);
                List<String> urls = htmlParser.getUrls(currUrl);
                for (String url : urls) {
                    if (url.contains(hostName) && !visited.contains(url)) {
                        queue.offer(url);
                        visited.add(url);
                    }
                }
            }
        }
        return res;
    }

    private String getHost(String url) {
        String[] strs = url.split("/");
        return strs[2];
    }
}
