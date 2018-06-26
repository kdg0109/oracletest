package com.ubivelox.oracle_test;

import lombok.Data;

@Data
class Emp
{
    private String ename;
    private String job;
    private String phone;





    public Emp(final String ename, final String job, final String phone)
    {
        this.ename = ename;
        this.job = job;
        this.phone = phone;
    }
}
