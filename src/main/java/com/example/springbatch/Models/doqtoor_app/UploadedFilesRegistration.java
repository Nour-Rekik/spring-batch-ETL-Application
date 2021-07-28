 package com.example.springbatch.Models.doqtoor_app;

 import com.fasterxml.jackson.annotation.JsonIgnore;

 import javax.persistence.*;
 import java.io.Serializable;
 import java.util.Objects;

@Entity
@Table(name = "uploaded_files_registration")
public class UploadedFilesRegistration implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;


    @Column(name = "file_url")
    private String fileUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadedFilesRegistration that = (UploadedFilesRegistration) o;
        return Objects.equals(id, that.id) && Objects.equals(fileUrl, that.fileUrl) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileUrl, user);
    }

    @Override
    public String toString() {
        return "UploadedFilesRegistration{" +
            "id=" + id +
            ", fileUrl='" + fileUrl + '\'' +
            ", user=" + user +
            '}';
    }
}


