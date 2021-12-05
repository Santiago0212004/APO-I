package model;

public class IcesiProject extends Company{
    private String projectId;

    public IcesiProject(String projectId){
        super("Universidad ICESI", "890.316.745-5");
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
