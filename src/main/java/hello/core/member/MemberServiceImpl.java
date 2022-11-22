package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //new키워드로 구현객체 선택해줘야함 MemoryMemberRepository선택
    private final MemberRepository memberRepository;

    //memberRepository는 MemoryMemberRepository를 사용한다.
    //생성자를 통해 MemberRepository의 new한 구현체를 만듬.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        //override된 MemoryMemberRepository의 save()메서드가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
