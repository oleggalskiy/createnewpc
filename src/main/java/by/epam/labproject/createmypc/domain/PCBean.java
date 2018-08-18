package by.epam.labproject.createmypc.domain;



public class PCBean {

    private Long idPC;
    private String date;
    private String pcCPU;
    private String pcMb;
    private String pcVga;
    private String pcRam;

    private User author;


    public PCBean() {
    }

    public PCBean(String pcCPU, String pcMb, String pcVga, String pcRam, User user) {
        this.pcCPU = pcCPU;
        this.pcMb = pcMb;
        this.pcVga = pcVga;
        this.pcRam = pcRam;
        this.author = user;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername(): "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getIdPC() {
        return idPC;
    }

    public void setIdPC(Long idPC) {
        this.idPC = idPC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPcCPU() {
        return pcCPU;
    }

    public void setPcCPU(String pcCPU) {
        this.pcCPU = pcCPU;
    }

    public String getPcMb() {
        return pcMb;
    }

    public void setPcMb(String pcMb) {
        this.pcMb = pcMb;
    }

    public String getPcVga() {
        return pcVga;
    }

    public void setPcVga(String pcVga) {
        this.pcVga = pcVga;
    }

    public String getPcRam() {
        return pcRam;
    }

    public void setPcRam(String pcRam) {
        this.pcRam = pcRam;
    }




}
