package com.JobAPI.JobAPI.repo;

import com.JobAPI.JobAPI.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "java developer", "text", 2, List.of("java", "spring")),
            new JobPost(2, "python developer", "text", 3, List.of("python", "django"))
    ));

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public JobPost getJob(int postId) {
        for (JobPost job : jobs) {
            if (job.getPostId() == postId) {
                return job;
            }
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost jobPost1 : jobs) {
            if (jobPost1.getPostId() == jobPost.getPostId()) {
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postId) {
        for (JobPost job : jobs) {
            if (job.getPostId() == postId){
                jobs.remove(job);
            }
        }
    }
}
