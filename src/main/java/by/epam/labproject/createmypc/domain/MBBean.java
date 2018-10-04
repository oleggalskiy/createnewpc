package by.epam.labproject.createmypc.domain;

public class MBBean {

    private final Long idMb;
    private final String mbName;
    private final String mbCpuSocket;
    private final String mbChipset;
    private final String mbMemoryType;
    private final Integer mbMemorySlots;
    private final Integer mbMemoryMaxGb;
    private final String mbVgaSup;
    private final String mbFabricator;

    public MBBean(final Long newIdMb,
             final String newMbName,
             final String newMbCpuSocket,
             final String newMbChipset,
             final String newMbMemoryType,
             final Integer newMbMemorySlots,
             final Integer newMbMemoryMaxGb,
             final String newMbVgaSup,
             final String newMbFabricator) {
       this.idMb = newIdMb;
       this.mbName = newMbName;
       this.mbCpuSocket = newMbCpuSocket;
       this.mbChipset = newMbChipset;
       this.mbMemoryType = newMbMemoryType;
       this.mbMemorySlots = newMbMemorySlots;
       this.mbMemoryMaxGb = newMbMemoryMaxGb;
       this.mbVgaSup = newMbVgaSup;
       this.mbFabricator = newMbFabricator;
    }

    public Long getIdMb() {
        return idMb;
    }

    public String getMbName() {
        return mbName;
    }

    public String getMbCpuSocket() {
        return mbCpuSocket;
    }

    public String getMbChipset() {
        return mbChipset;
    }

    public String getMbMemoryType() {
        return mbMemoryType;
    }

    public Integer getMbMemorySlots() {
        return mbMemorySlots;
    }

    public Integer getMbMemoryMaxGb() {
        return mbMemoryMaxGb;
    }

    public String getMbVgaSup() {
        return mbVgaSup;
    }

    public String getMbFabricator() {
        return mbFabricator;
    }

    public static final class MBBeanBuilder {
        private  Long nestedIdMb;
        private  String nestedMbName;
        private  String nestedMbCpuSocket;
        private  String nestedMbChipset;
        private  String nestedMbMemoryType;
        private  Integer nestedMbMemorySlots;
        private  Integer nestedMbMemoryMaxGb;
        private  String nestedMbVgaSup;
        private  String nestedMbFabricator;

        private MBBeanBuilder() {
        }

        public static MBBeanBuilder newBuilder() {
            return new MBBeanBuilder();
        }

        public MBBeanBuilder setNestedIdMb(Long idMb) {
            this.nestedIdMb = idMb;
            return this;
        }

        public MBBeanBuilder setNestedMbName(String nestedMbName) {
            this.nestedMbName = nestedMbName;
            return this;
        }

        public MBBeanBuilder setNestedMbCpuSocket(String nestedMbCpuSocket) {
            this.nestedMbCpuSocket = nestedMbCpuSocket;
            return this;
        }

        public MBBeanBuilder setNestedMbChipset(String nestedMbChipset) {
            this.nestedMbChipset = nestedMbChipset;
            return this;
        }

        public MBBeanBuilder setNestedMbMemoryType(String nestedMbMemoryType) {
            this.nestedMbMemoryType = nestedMbMemoryType;
            return this;
        }

        public MBBeanBuilder setNestedMbMemorySlots(Integer nestedMbMemorySlots) {
            this.nestedMbMemorySlots = nestedMbMemorySlots;
            return this;
        }

        public MBBeanBuilder setNestedMbMemoryMaxGb(Integer nestedMbMemoryMaxGb) {
            this.nestedMbMemoryMaxGb = nestedMbMemoryMaxGb;
            return this;
        }

        public MBBeanBuilder setNestedMbVgaSup(String nestedMbVgaSup) {
            this.nestedMbVgaSup = nestedMbVgaSup;
            return this;
        }

        public MBBeanBuilder setNestedMbFabricator(String nestedMbFabricator) {
            this.nestedMbFabricator = nestedMbFabricator;
            return this;
        }

        public MBBean build() {
            return new MBBean(   nestedIdMb,
               nestedMbName,
               nestedMbCpuSocket,
               nestedMbChipset,
               nestedMbMemoryType,
               nestedMbMemorySlots,
               nestedMbMemoryMaxGb,
               nestedMbVgaSup,
               nestedMbFabricator);
        }
    }
    public static MBBeanBuilder newBuilder(){
        return new MBBeanBuilder();
    }
}
