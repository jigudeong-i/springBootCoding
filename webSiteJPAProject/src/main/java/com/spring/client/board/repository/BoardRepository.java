package com.spring.client.board.repository;

import com.spring.client.board.domain.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

//public interface JpaRepository<T, ID> extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
public interface BoardRepository extends JpaRepository<Board, Long> {
    // Spring Data JPA는 메서드의 이름만으로 원하는 질의(Query)를 실행할 수 있는 방법을 제공한다. findBy

    // findBy[FieldName]
    Board findByTitle(String title);

    //findBy[FieldName]Containing
    List<Board> findByTitleContaining(String title);
    List<Board> findByNameContaining(String name);
    List<Board> findByContentContaining(String content);

    //findBy[FieldName][Between]
    List<Board> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //findByOrderBy[FieldName][Desc]
    List<Board> findByOrderByNoDesc();


    //JpaRepository---------------
    // service에서 사용하는 메서드 ----------------------------------
    Page<Board> findAll(Pageable pageable);

    Page<Board> findByTitleContaining(String keyword, Pageable pageable);
    Page<Board> findByNameContaining(String name, Pageable pageable);
    Page<Board> findByContentContaining(String content, Pageable pageable);

    Page<Board> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);


    /*JPQL
    JPA에서 사용하는 객체지향 쿼리 언어이다.
    데이터 베이스 SQL 쿼리 언어와 유사하지만 테이블과 컬럼 이름 대신
    매핑한 엔티티 이름과 속성 이름을 사용한다.
    기본형식: SELECT 별칭 FROM 엔티티 이름 AS 별칭
     */

    @Query("SELECT b FROM Board b")
    public List<Board> boardList();

    // ? 다음에 워치 값을 지정하는 위치 기준 파라미터를 사용
    @Query("SELECT b FROM Board b WHERE b.no = ?1")
    public Board boardDetail(Long no);

    @Query("SELECT b FROM Board b")
    public Page<Board> boardListPaging(Pageable pageable);

    // 네이티브 SQL : JPA에서 SQL을 직접 사용할 수 있다.
    // 사용방법 : @Query(value = "쿼리문", nativeQuery = ture)

    @Query(value = "SELECT no, name, title, content, hit, reg_date FROM boot_board ORDER BY no DESC", nativeQuery = true)
    public List<Board> boardAllList();

    @Transactional
    @Modifying
    @Query("DELETE FROM Board b WHERE b.no BETWEEN :start AND :end")
    void deleteByIdBetween(@Param("start") Long start, @Param("end") Long end);

}
