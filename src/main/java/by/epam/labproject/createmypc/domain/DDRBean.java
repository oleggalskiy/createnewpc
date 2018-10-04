package by.epam.labproject.createmypc.domain;

public class DDRBean {
    private  Long idDdr;
    private  String ddrName;
    private  String ddrType;
    private  String ddrForm;
    private  String ddrFrequency;
    private  String ddrSize;
    private  String ddrFabricator;

    public DDRBean(Long newIdDdr,
                   String newDdrName,
                   String newDdrType,
                   String newDdrForm,
                   String newDdrFrequency,
                   String newDdrSize,
                   String newDdrFabricator) {
        this.idDdr = newIdDdr;
        this.ddrName = newDdrName;
        this.ddrType = newDdrType;
        this.ddrForm = newDdrForm;
        this.ddrFrequency = newDdrFrequency;
        this.ddrSize = newDdrSize;
        this.ddrFabricator = newDdrFabricator;
    }

    public Long getIdDdr() {
        return idDdr;
    }

    public String getDdrName() {
        return ddrName;
    }

    public String getDdrType() {
        return ddrType;
    }

    public String getDdrForm() {
        return ddrForm;
    }

    public String getDdrFrequency() {
        return ddrFrequency;
    }

    public String getDdrSize() {
        return ddrSize;
    }

    public String getDdrFabricator() {
        return ddrFabricator;
    }


    public static class DDRBuilder{
        private Long nestedIdDdr;
        private  String nestedDdrName;
        private  String nestedDdrType;
        private  String nestedDdrForm;
        private  String nestedDdrFrequency;
        private  String nestedDdrSize;
        private  String nestedDdrFabricator;

        public DDRBuilder() {
        }

        public DDRBuilder setNestedIdDdr(Long nestedIdDdr) {
            this.nestedIdDdr = nestedIdDdr;
            return this;
        }

        public DDRBuilder setNestedDdrName(String nestedDdrName) {
            this.nestedDdrName = nestedDdrName;
            return this;
        }

        public DDRBuilder setNestedDdrType(String nestedDdrType) {
            this.nestedDdrType = nestedDdrType;
            return this;
        }

        public DDRBuilder setNestedDdrForm(String nestedDdrForm) {
            this.nestedDdrForm = nestedDdrForm;
            return this;
        }

        public DDRBuilder setNestedDdrFrequency(String nestedDdrFrequency) {
            this.nestedDdrFrequency = nestedDdrFrequency;
            return this;
        }

        public DDRBuilder setNestedDdrSize(String nestedDdrSize) {
            this.nestedDdrSize = nestedDdrSize;
            return this;
        }

        public DDRBuilder setNestedDdrFabricator(String nestedDdrFabricator) {
            this.nestedDdrFabricator = nestedDdrFabricator;
            return this;
        }

        public DDRBean build() {
            return new DDRBean(nestedIdDdr,
               nestedDdrName,
               nestedDdrType,
               nestedDdrForm,
               nestedDdrFrequency,
               nestedDdrSize,
               nestedDdrFabricator);

        }
    }
    public static DDRBuilder newBuilder(){
        return new DDRBuilder();
    }
}
