package com.example.board.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //테이블로 매핑하지 않고, 자식 entity에게 매핑정보를 상속하기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class) //jap에게 entity는 auditing 기능을 사용한다는 것을 알리는 어노테이션
public class TimeEntity {

    @CreatedDate
    @Column (updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
