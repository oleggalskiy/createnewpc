package by.epam.labproject.createmypc.domain;

public class CPUBean {
    private final Long idCpu;
    private final String nameCPU;
    private final String cpuSocket;
    private final String cpuCore;
    private final String cpuNumberCores;
    private final String cpuProcess;
    private final String cpuFrequency;
    private final String cpuSystemBus;
    private final String cpuFabricator;


    public CPUBean(final Long newIdCpu,
                   final String newNameCPU,
                   final String newCpuSocket,
                   final String newCpuCore,
                   final String newCpuNumberCores,
                   final String newCpuProcess,
                   final String newCpuFrequency,
                   final String newCpuSystemBus,
                   final String newCpuFabricator) {
        this.idCpu = newIdCpu;
        this.nameCPU = newNameCPU;
        this.cpuSocket = newCpuSocket;
        this.cpuCore = newCpuCore;
        this.cpuNumberCores = newCpuNumberCores;
        this.cpuProcess = newCpuProcess;
        this.cpuFrequency = newCpuFrequency;
        this.cpuSystemBus = newCpuSystemBus;
        this.cpuFabricator = newCpuFabricator;
    }

    public Long getIdCpu() {
        return idCpu;
    }

    public String getNameCPU() {
        return nameCPU;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }

    public String getCpuCore() {
        return cpuCore;
    }

    public String getCpuNumberCores() {
        return cpuNumberCores;
    }

    public String getCpuProcess() {
        return cpuProcess;
    }

    public String getCpuFrequency() {
        return cpuFrequency;
    }

    public String getCpuSystemBus() {
        return cpuSystemBus;
    }

    public String getCpuFabricator() {
        return cpuFabricator;
    }

    public static class CPUBuilder{
        private Long nestedIdCpu;
        private String nestedNameCPU;
        private String nestedCpuSocket;
        private String nestedCpuCore;
        private String nestedCpuNumberCores;
        private String nestedCpuProcess;
        private String nestedCpuFrequency;
        private String nestedCpuSystemBus;
        private String nestedCpuFabricator;

        private CPUBuilder() {
        }

        public CPUBuilder setNestedIdCpu(Long nestedIdCpu) {
            this.nestedIdCpu = nestedIdCpu;
            return this;
        }

        public CPUBuilder setNestedNameCPU(String nestedNameCPU) {
            this.nestedNameCPU = nestedNameCPU;
            return this;
        }

        public CPUBuilder setNestedCpuSocket(String nestedCpuSocket) {
            this.nestedCpuSocket = nestedCpuSocket;
            return this;
        }

        public CPUBuilder setNestedCpuCore(String nestedCpuCore) {
            this.nestedCpuCore = nestedCpuCore;
            return this;
        }

        public CPUBuilder setNestedCpuNumberCores(String nestedCpuNumberCores) {
            this.nestedCpuNumberCores = nestedCpuNumberCores;
            return this;
        }

        public CPUBuilder setNestedCpuProcess(String nestedCpuProcess) {
            this.nestedCpuProcess = nestedCpuProcess;
            return this;
        }

        public CPUBuilder setNestedCpuFrequency(String nestedCpuFrequency) {
            this.nestedCpuFrequency = nestedCpuFrequency;
            return this;
        }

        public CPUBuilder setNestedCpuSystemBus(String nestedCpuSystemBus) {
            this.nestedCpuSystemBus = nestedCpuSystemBus;
            return this;
        }

        public CPUBuilder setNestedCpuFabricator(String nestedCpuFabricator) {
            this.nestedCpuFabricator = nestedCpuFabricator;
            return this;
        }

        public CPUBean build() {
            return new CPUBean(nestedIdCpu,
                    nestedNameCPU,
                    nestedCpuSocket,
                    nestedCpuCore,
                    nestedCpuNumberCores,
                    nestedCpuProcess,
                    nestedCpuFrequency,
                    nestedCpuSystemBus,
                    nestedCpuFabricator);

        }
    }
    public static  CPUBuilder newBuilder(){
        return new CPUBuilder();
    }

}
