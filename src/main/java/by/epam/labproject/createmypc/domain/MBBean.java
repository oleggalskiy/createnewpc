package by.epam.labproject.cratemynewpc.domain;

public class MBBean {

    private Long idMb;
    private Integer mbName;
    private Integer mbCpuSocket;
    private Integer mbChipset;
    private Integer mbMemoryType;
    private Integer mbMemorySlots;
    private Integer mbMemoryMaxGb;
    private Integer mbVgaSyp;

    public Long getIdMb() {
        return idMb;
    }

    public void setIdMb(Long idMb) {
        this.idMb = idMb;
    }

    public Integer getMbName() {
        return mbName;
    }

    public void setMbName(Integer mbName) {
        this.mbName = mbName;
    }

    public Integer getMbCpuSocket() {
        return mbCpuSocket;
    }

    public void setMbCpuSocket(Integer mbCpuSocket) {
        this.mbCpuSocket = mbCpuSocket;
    }

    public Integer getMbChipset() {
        return mbChipset;
    }

    public void setMbChipset(Integer mbChipset) {
        this.mbChipset = mbChipset;
    }

    public Integer getMbMemoryType() {
        return mbMemoryType;
    }

    public void setMbMemoryType(Integer mbMemoryType) {
        this.mbMemoryType = mbMemoryType;
    }

    public Integer getMbMemorySlots() {
        return mbMemorySlots;
    }

    public void setMbMemorySlots(Integer mbMemorySlots) {
        this.mbMemorySlots = mbMemorySlots;
    }

    public Integer getMbMemoryMaxGb() {
        return mbMemoryMaxGb;
    }

    public void setMbMemoryMaxGb(Integer mbMemoryMaxGb) {
        this.mbMemoryMaxGb = mbMemoryMaxGb;
    }

    public Integer getMbVgaSyp() {
        return mbVgaSyp;
    }

    public void setMbVgaSyp(Integer mbVgaSyp) {
        this.mbVgaSyp = mbVgaSyp;
    }

    public Integer getMbFabricator() {
        return mbFabricator;
    }

    public void setMbFabricator(Integer mbFabricator) {
        this.mbFabricator = mbFabricator;
    }

    private Integer mbFabricator;
}
