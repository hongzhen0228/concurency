package com.chz.publish;

import com.chz.threadsafe.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class Escape {
    private int thisCouldBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}",Escape.this.thisCouldBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
