package SpringBootCore.core.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(long memberId);
}
