package by.epam.labproject.createmypc.domain;


import java.time.LocalDate;


public class PCBean {

    private final Long idPC;
    private final String date;
    private final Integer pcIdCpu;
    private final Integer pcIdMb;
    private final Integer pcIdVga;
    private final Integer pcIdRam;
    private final boolean isActive;

    private User author;


    public PCBean(final Long newIdPC,
                  final String newDate,
                  final Integer newIdPCCpu,
                  final Integer newIdPCMb,
                  final Integer newIdPCVga,
                  final Integer newIdPCRam,
                  final boolean newIsActive,
                  final User newAuthor) {
        this.idPC = newIdPC;
        this.date = newDate;
        this.pcIdCpu = newIdPCCpu;
        this.pcIdMb = newIdPCMb;
        this.pcIdVga = newIdPCVga;
        this.pcIdRam = newIdPCRam;
        this.isActive = newIsActive;
        this.author = newAuthor;
    }

    public String getAutorId(){return author.getId().toString();}

    public String getAuthorName(){
        return author != null ? author.getUsername(): "<none>";
    }

    public Long getIdPC() {
        return idPC;
    }

    public String getDate() {
        return date;
    }

    public Integer getPcIdCpu() {
        return pcIdCpu;
    }

    public Integer getPcIdMb() {
        return pcIdMb;
    }

    public Integer getPcIdVga() {
        return pcIdVga;
    }

    public Integer getPcIdRam() {
        return pcIdRam;
    }

    public boolean getActive() {return isActive;
    }

    public User getAuthor() { return author;
    }

    public PCBean setAuthor(User user){
       this.author = user;
       return this;
    }


    public static class PCBuilder{
        private Long nestedIdPC;
        private String nestedDate = LocalDate.now().toString();
        private Integer nestedPcCpu;
        private Integer nestedPcMb;
        private Integer nestedPcVga;
        private Integer nestedPcRam;
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

        public PCBuilder setPcCpu(Integer nestedPcCpu) {
            this.nestedPcCpu = nestedPcCpu;
            return this;
        }

        public PCBuilder setPcMb(Integer nestedPcMb) {
            this.nestedPcMb = nestedPcMb;
            return this;
        }

        public PCBuilder setPcVga(Integer nestedPcVga) {
            this.nestedPcVga = nestedPcVga;
            return this;
        }

        public PCBuilder setPcRam(Integer nestedPcRam) {
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
