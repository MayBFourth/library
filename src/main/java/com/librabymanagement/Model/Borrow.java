package com.librabymanagement.Model;

import java.util.Date;

public class Borrow {
    private Long id;
    private Long userId;
    private Long bookId;
    private Date borrowDate;
    private Date returnDate;
    private boolean isReturned;
    private boolean isAvailable;
}
