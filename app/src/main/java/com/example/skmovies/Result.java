package com.example.skmovies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("page")
    @Expose
    Integer pages;
    @SerializedName("total_pages")
    @Expose
    Integer total_pages;
    @SerializedName("total_results")
    @Expose
    Integer total_results;
    @SerializedName("results")
    @Expose
    List<Movie> result = null;

    public Result(Integer pages, Integer total_pages, Integer total_results, List<Movie> result) {
        this.pages = pages;
        this.total_pages = total_pages;
        this.total_results = total_results;
        this.result = result;
    }

    public Result() {
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public List<Movie> getResult() {
        return result;
    }

    public void setResult(List<Movie> result) {
        this.result = result;
    }
}
