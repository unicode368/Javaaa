package model;

public enum Group {
    WORK {
        @Override
        public String toString() {
            return "робота";
        }
    },
    FAMILY {
        @Override
        public String toString() {
            return "сім'я";
        }
    },
    FRIENDS {
        @Override
        public String toString() {
            return "друзі";
        }
    }
}
