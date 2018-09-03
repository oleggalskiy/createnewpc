package by.epam.labproject.createmypc.domain;



public class PCBean {

    private final Long idPC;
    private final String date;
    private final String pcCpu;
    private final String pcMb;
    private final String pcVga;
    private final String pcRam;
    private final boolean isActive;

    private final User author;


    public PCBean(final Long newIdPC, final String newDate, final String newPCcpu, final String newPCMb, final String newPCVga,final String newPCRam, final boolean newIsActive,final User newAuthor) {
        this.idPC = newIdPC;
        this.date = newDate;
        this.pcCpu = newPCcpu;
        this.pcMb = newPCMb;
        this.pcVga = newPCVga;
        this.pcRam = newPCRam;
        this.isActive = newIsActive;
        this.author = newAuthor;
    }

    public String getAutorId(){return  author !=null ? author.getId().toString(): "<none>";}

    public String getAuthorName(){
        return author != null ? author.getUsername(): "<none>";
    }

    public Long getIdPC() {
        return idPC;
    }

    public String getDate() {
        return date;
    }

    public String getPcCpu() {
        return pcCpu;
    }

    public String getPcMb() {
        return pcMb;
    }

    public String getPcVga() {
        return pcVga;
    }

    public String getPcRam() {
        return pcRam;
    }

    public boolean getActive() {return isActive;
    }

    public User getAuthor() { return author;
    }


    public static class PCBuilder{
        private Long nestedIdPC;
        private String nestedDate;
        private String nestedPcCpu;
        private String nestedPcMb;
        private String nestedPcVga;
        private String nestedPcRam;
        private boolean nestedIsActive;
        private User nestedAuthor;

        public PCBuilder setIdPC(Long nestedIdPC) {
            this.nestedIdPC = nestedIdPC;
            return this;
        }

        public PCBuilder setDate(String nestedDate) {
            this.nestedDate = nestedDate;
            return this;
        }

        public PCBuilder setPcCpu(String nestedPcCpu) {
            this.nestedPcCpu = nestedPcCpu;
            return this;
        }

        public PCBuilder setPcMb(String nestedPcMb) {
            this.nestedPcMb = nestedPcMb;
            return this;
        }

        public PCBuilder setPcVga(String nestedPcVga) {
            this.nestedPcVga = nestedPcVga;
            return this;
        }

        public PCBuilder setPcRam(String nestedPcRam) {
            this.nestedPcRam = nestedPcRam;
            return this;
        }

        public PCBuilder setIsActive(boolean nestedIsActive) {
            this.nestedIsActive = nestedIsActive;
            return this;
        }

        public PCBuilder setAuthor(User nestedAuthor) {
            this.nestedAuthor = nestedAuthor;
            return this;
        }
        public PCBean build(){
            return new PCBean(nestedIdPC,nestedDate, nestedPcCpu, nestedPcMb, nestedPcVga, nestedPcRam,nestedIsActive, nestedAuthor);
        }
    }
    public static  PCBuilder newBuilder(){
        return new PCBuilder();
    }
}
