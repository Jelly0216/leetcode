import java.util.ArrayList;
import java.util.List;

public class FileSystem588 {
    private final Directory root;

    public FileSystem588() {
        root = new Director("/", null);
    }

    private List<Entry> resolve(String path) {
        assert path.startsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<>(components.length + 1);
        Entry entry = root;
        for (String component : components) {
            if (entry == null || !(entry instanceof Directory)) {
                throw new IllegalArgumentException("invalid path:" + path);
            }
            if (!components.isEmpty()) {
                entry = ((Directory) entry).getChild(component);
                entries.add(entry);
            }
        }
        return entries;
    }

    public void mkdir(String path) {
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Directory already exists:" + path);
        }
        String[] components = path.split("/");
        final String dirName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }

    public void createFile(String path) {
        assert !path.endsWith("/");
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("File already exits:" + path);
        }
        final String fileName = path.substring(path.lastIndexOf("/") + 1);
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        File file = new File(fileName, parent, 0);
        parent.addEntry(file);
    }

    public void delete(String path) {
        assert !path.endsWith("/");
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) == null) {
            throw new IllegalArgumentException("File not exists:" + path);
        }
        final String name = path.substring(path.);
    }

    private static abstract class Entry {
        protected Directory parent;
        protected long created;
        protected long lastUpdated;
        protected long lastAccessed;
        protected String name;

        public Entry(String n, Directory p) {
            this.name = n;
            this.parent = p;
            this.created = System.currentTimeMillis();
        }

        public boolean delete() {
            if (parent == null) {
                return false;
            }
            return parent.deleteEntry(this);
        }

        public abstract int size();

        public String getFullPath() {
            if (parent == null) {
                return name;
            }
            else {
                return parent.getFullPath() + "/" + name;
            }
        }

        public long getCreationTime() {
            return created;
        }

        public long getLastAccessedTime() {
            return lastAccessed;
        }

        public void changeName(String n) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static class File extends Entry {
        private String content;
        private int size;
        public File(String n, Directory p, int sz) {
            super(n, p);
            size = sz;
        }

        public int size() {
            return size;
        }

        public String getContents() {
            return content;
        }

        public void setContents(String c) {
            content = c;
        }
    }

    private static class Directory extends Entry {
        private List<Entry> contents;

        public Directory(String n, Directory p) {
            super(n, p);
            contents = new ArrayList<>();
        }

        public int size() {
            int size = 0;
            for (Entry e : contents) {
                size += e.size();
            }
            return size;
        }

        public int numberOfFiles() {
            int count = 0;
            for (Entry e : contents) {
                if (e instanceof Directory) {
                    count++;
                    Directory d = (Directory)e;
                    count += d.numberOfFiles();
                }
                else if (e instanceof File) {
                    count++;
                }
            }
            return count;
        }

        public boolean deleteEntry(Entry entry) {
            return contents.remove(entry);
        }

        public void addEntry(Entry entry) {
            contents.add(entry);
        }
    }
}
