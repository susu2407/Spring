package kr.co.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    // 필드(속성) 주입 (비권장, 직접 주입을 권장하지 않음)
    @Autowired
    private CPU cpu;

    // 생성자 주입(final 속성)
    private RAM ram;

    @Autowired
    public Computer(RAM ram) {
        this.ram = ram;
    }

    // 세터 주입 (권장)
    private HDD hdd;

    @Autowired
    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }


    public void show() {
        cpu.show();
        ram.show();
        hdd.show();
    }

}
