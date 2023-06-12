package org.example;

/**
 * A folder has a name, children, and an optional parent. A child can't be added
 * twice with documentation comments
 */
public class Folder {
    private String name;
    private Folder parent;
    private Folder[] children;

    /**
     * @param name
     *                 the name of the folder
     * @param parent
     *                 the parent folder
     * @param children
     *                 the children of the folder
     */
    public Folder(String name, Folder parent, Folder[] children) {
        this.name = name;
        this.parent = parent;
        this.children = children;
    }

    /**
     * @return the name of the folder
     */
    public String getName() {
        return name;
    }

    /**
     * @return the parent folder
     */
    public Folder getParent() {
        return parent;
    }

    /**
     * @return the children of the folder
     */
    public Folder[] getChildren() {
        return children;
    }
}
