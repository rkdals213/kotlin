package coroutine

data class Member(
    val id: Long = 0,
    var name: String = "",
    var age: Int? = null
) {
    fun update(updateMember: Member.() -> Unit) {
        updateMember()
    }
}

data class Team(
    val id: Long = 0,
    var name: String = "",
    val members: MutableList<Member> = mutableListOf()
) {
    fun addMembers(vararg member: Member) {
        members.addAll(member)
    }
}

fun createMember(makeMember: Member.() -> Unit): Member {
    val member = Member()
    member.makeMember()
    return member
}

fun createTeam(makeTeam: Team.() -> Unit): Team {
    val team = Team()
    team.makeTeam()
    return team
}


fun main() {
    val team = createTeam {
        name = "My Team"
        addMembers(
            createMember {
                name = "kang"
                age = 31
            },
            createMember {
                name = "min"
                age = 10
            }
        )
    }

    println(team)

    val member = createMember {
        name = "kang"
    }

    println(member)

    member.update {
        name = "MinHyeong"
        age = 30
    }

    println(member)
}