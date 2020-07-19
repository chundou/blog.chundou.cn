package cn.chundou.blog.constant;

public enum CommonResponseEnum {
    SUCCESS(0L, "Success"),
    UNKNOWN_ERROR(999999L, "Unknown error")
    ;

    private Long status;
    private String message;

    CommonResponseEnum(Long status, String message) {
        this.status = status;
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
