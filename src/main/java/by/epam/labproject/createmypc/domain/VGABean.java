package by.epam.labproject.createmypc.domain;

public class VGABean {

    private final Long idVga;
    private final String vgaName;
    private final String  vgaGraphProc;
    private final String  vgaFrecProcMhz;
    private final String  vgaInterface;
    private final String  vgaVramMb;
    private final String  vgaTypeVram;
    private final String  vgShaders;
    private final String  vgaFabricator;



    public VGABean(
            final Long newIdVga,
            final String newVgaName,
            final String newVgShaders,
            final String newVgaInterface,
            final String newVgaFabricator,
            final String newVgaGraphProc,
            final String newVgaVramMb,
            final String newVgaTypeVram,
            final String newVgaFrecProcMhz){
        this.idVga = newIdVga;
        this.vgaName = newVgaName;
        this.vgShaders = newVgShaders;
        this.vgaInterface = newVgaInterface;
        this.vgaFabricator = newVgaFabricator;
        this.vgaGraphProc = newVgaGraphProc;
        this.vgaVramMb = newVgaVramMb;
        this.vgaTypeVram = newVgaTypeVram;
        this.vgaFrecProcMhz = newVgaFrecProcMhz;
    }

    public Long getIdVga() {
        return idVga;
    }

    public String getVgaName() {
        return vgaName;
    }

    public String getVgaGraphProc() {
        return vgaGraphProc;
    }

    public String getVgaFrecProcMhz() {
        return vgaFrecProcMhz;
    }

    public String getVgaInterface() {
        return vgaInterface;
    }

    public String getVgaVramMb() {
        return vgaVramMb;
    }

    public String getVgaTypeVram() {
        return vgaTypeVram;
    }

    public String getVgShaders() {
        return vgShaders;
    }

    public String getVgaFabricator() {
        return vgaFabricator;
    }

    public static final class VGABeanBuilder {
        private Long nestedIdVga;
        private String nestedVgaName;
        private String nestedVgaGraphProc;
        private String nestedVgaFrecProcMhz;
        private String nestedVgaInterface;
        private String nestedVgaVramMb;
        private String nestedVgaTypeVram;
        private String nestedVgShaders;
        private String nestedVgaFabricator;

        private VGABeanBuilder() {
        }

        public static VGABeanBuilder newBuilder() {
            return new VGABeanBuilder();
        }

        public VGABeanBuilder setNestedIdVga(Long idVga) {
            this.nestedIdVga = idVga;
            return this;
        }

        public VGABeanBuilder setNestedVgaName(String vgaName) {
            this.nestedVgaName = vgaName;
            return this;
        }

        public VGABeanBuilder setNestedVgaGraphProc(String vgaGraphProc) {
            this.nestedVgaGraphProc = vgaGraphProc;
            return this;
        }

        public VGABeanBuilder setNestedVgaFrecProcMhz(String vgaFrecProcMhz) {
            this.nestedVgaFrecProcMhz = vgaFrecProcMhz;
            return this;
        }

        public VGABeanBuilder setNestedVgaInterface(String vgaInterface) {
            this.nestedVgaInterface = vgaInterface;
            return this;
        }

        public VGABeanBuilder setNestedVgaVramMb(String vgaVramMb) {
            this.nestedVgaVramMb = vgaVramMb;
            return this;
        }

        public VGABeanBuilder setNestedVgaTypeVram(String vgaTypeVram) {
            this.nestedVgaTypeVram = vgaTypeVram;
            return this;
        }

        public VGABeanBuilder setNestedVgShaders(String vgShaders) {
            this.nestedVgShaders = vgShaders;
            return this;
        }

        public VGABeanBuilder setNestedVgaFabricator(String vgaFabricator) {
            this.nestedVgaFabricator = vgaFabricator;
            return this;
        }

        public VGABean build() {
            return new VGABean(nestedIdVga,
              nestedVgaName,
              nestedVgaGraphProc,
              nestedVgaFrecProcMhz,
              nestedVgaInterface,
              nestedVgaVramMb,
              nestedVgaTypeVram,
              nestedVgShaders,
              nestedVgaFabricator);
        }
    }
    public static VGABeanBuilder newBuilder(){
        return new VGABeanBuilder();
    }
}
