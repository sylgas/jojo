package pl.lusy.jojo.journeyjournal.data.mapper

import org.junit.Assert.*
import org.junit.Test
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanStepEntity
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanSteps
import pl.lusy.jojo.journeyjournal.data.model.PlanStep

class PlanMapperTest {

    private val planStepsEntities = listOf(
        PlanStepEntity(id = 11L, planId = 12L, title = "13", description = "14"),
        PlanStepEntity(id = 21L, planId = 22L, title = "23", description = "24"),
        PlanStepEntity(id = 31L, planId = 32L, title = "33", description = "34")
    )

    @Test
    internal fun testToPlanIfNoSteps() {
        val planSteps = PlanSteps()
        val plan = planSteps.toPlan()
        assertNotNull(plan)
        assertTrue(plan.steps.isEmpty())
    }

    @Test
    fun testToPlanSteps() {
        val planSteps = PlanSteps(planSteps = planStepsEntities)
        val plan = planSteps.toPlan()
        assertEquals(3, plan.steps.size)
        assertPlanStep(plan.steps[0], title = "13", description = "14")
        assertPlanStep(plan.steps[1], title = "23", description = "24")
        assertPlanStep(plan.steps[2], title = "33", description = "34")
    }

    private fun assertPlanStep(planStep: PlanStep,
                               title: String?,
                               description: String?
    ) {
        assertEquals(title, planStep.title)
        assertEquals(description, planStep.description)
    }
}