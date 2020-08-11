package com.example.webapidemo40;

class VideoObject {
    int id;
    int publisher_id;
    int content_type;
    int tab;
    String title;
    String avatar;
    int status;
    int deleted;
    int user_created;
    int user_modified;
    String date_created;
    String date_modified;
    int parent_id;
    int lft;
    int rgt;
    int level;
    String short_code;
    String command_code;
    double price;
    String finished_message;
    String help_message;
    int icash;
    String thumb;

    public VideoObject(int id, int publisher_id, int content_type, int tab, String title, String avatar, int status, int deleted, int user_created, int user_modified, String date_created, String date_modified, int parent_id, int lft, int rgt, int level, String short_code, String command_code, double price, String finished_message, String help_message, int icash, String thumb) {
        this.id = id;
        this.publisher_id = publisher_id;
        this.content_type = content_type;
        this.tab = tab;
        this.title = title;
        this.avatar = avatar;
        this.status = status;
        this.deleted = deleted;
        this.user_created = user_created;
        this.user_modified = user_modified;
        this.date_created = date_created;
        this.date_modified = date_modified;
        this.parent_id = parent_id;
        this.lft = lft;
        this.rgt = rgt;
        this.level = level;
        this.short_code = short_code;
        this.command_code = command_code;
        this.price = price;
        this.finished_message = finished_message;
        this.help_message = help_message;
        this.icash = icash;
        this.thumb = thumb;
    }

}
