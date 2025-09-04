package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;

public class BoardSqlProvider {
    public String updateQuery(Board board) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE spring_board SET ");
        sql.append("b_title = #{boardTitle}, ");
        sql.append("b_content = #{boardContent} ");
        if(board.getBoardPasswd() != null && !board.getBoardPasswd().isEmpty()){
            sql.append(", b_pwd = #{boardPasswd} ");
        }
        sql.append("WHERE b_num = #{boardNumber} ");

        return sql.toString();
    }
}
