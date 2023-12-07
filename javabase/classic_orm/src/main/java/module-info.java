module perf.rush.javabase.classic.orm.main {
    requires static lombok;

    requires spring.web;
    requires spring.boot;
    requires spring.context;
    requires spring.tx;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.boot.autoconfigure;

    requires jakarta.persistence;
    requires com.fasterxml.jackson.annotation;
}