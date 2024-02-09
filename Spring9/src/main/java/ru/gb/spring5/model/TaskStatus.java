package ru.gb.spring5.model;
public enum TaskStatus {
    COMPLETED{
        @Override
        public String toString() {
            return "Завершена";
        }
    },
    IN_PROGRESS{
        @Override
        public String toString() {
            return "В работе";
        }
    },
    NOT_STARTED{
        @Override
        public String toString() {
            return "Не начата";
        }
    }
}