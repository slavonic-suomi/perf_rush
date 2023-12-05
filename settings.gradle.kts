rootProject.name = "perf_rush"
include("javabase")
include("javabase:classic_orm")
findProject(":javabase:classic_orm")?.name = "classic_orm"
