package com.example.tourist;

public class Story {
    private String storyTitle;
    private String storyImgUrl;
    private String storyDesc;
    private String servProvEmail;
    private String storyPubDate;

//    public Story(String storyTitle, String storyImgUrl, String storyDesc, String storyPubDate) {
//        this.storyTitle = storyTitle;
//        this.storyImgUrl = storyImgUrl;
//        this.storyDesc = storyDesc;
//        this.storyPubDate = storyPubDate;
//    }
    public Story(String storyTitle, String storyImgUrl, String storyDesc, String servProvEmail) {

        this.storyTitle = storyTitle;
        this.storyImgUrl = storyImgUrl;
        this.storyDesc = storyDesc;
        this.servProvEmail = servProvEmail;
    }
    public Story(){}

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryImgUrl() {
        return storyImgUrl;
    }

    public void setStoryImgUrl(String storyImgUrl) {
        this.storyImgUrl = storyImgUrl;
    }

    public String getStoryDesc() {
        return storyDesc;
    }

    public void setStoryDesc(String storyDesc) {
        this.storyDesc = storyDesc;
    }

    public String getStoryPubDate() {
        return storyPubDate;
    }

    public void setStoryPubDate(String storyPubDate) {
        this.storyPubDate = storyPubDate;
    }
}
