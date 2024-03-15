package org.example.models;

import java.util.List;

@lombok.Data
public class AllProduct {
    private List<Product> products;
    private long total;
    private long skip;
    private long limit;
}
