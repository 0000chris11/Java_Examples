package list.set;

class Persona implements Comparable<Persona>{

    private int id;
        private String name;

        Persona(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        int getId() {
            return id;
        }
        void setId(int id) {
            this.id = id;
        }
        String getName() {
            return name;
        }
        void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Persona o) {
            return this.getId() - o.getId();
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Persona other = (Persona) obj;
            if (id != other.id)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        
}
