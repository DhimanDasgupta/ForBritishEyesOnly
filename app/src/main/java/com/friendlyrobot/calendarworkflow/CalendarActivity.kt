package com.friendlyrobot.calendarworkflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.friendlyrobot.data.provideStore
import com.squareup.workflow.diagnostic.SimpleLoggingDiagnosticListener
import com.squareup.workflow.ui.ViewRegistry
import com.squareup.workflow.ui.WorkflowRunner
import com.squareup.workflow.ui.setContentWorkflow

private val viewRegistry = ViewRegistry(calendarRendering, loadingRendering)

class HelloWorkflowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentWorkflow(viewRegistry) {
            WorkflowRunner.Config(
                CalendarWorkflow(provideStore(applicationContext)),
                diagnosticListener = SimpleLoggingDiagnosticListener()
            )
        }
    }

    // To opt-in to state saving, use this alternative and
    // implement StatefulWorkflow.snapshotState.
//
//    private lateinit var runner: WorkflowRunner<Unit>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        runner = setContentWorkflow(viewRegistry) {
//            WorkflowRunner.Config(HelloWorkflow, Unit)
//        }
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        runner.onSaveInstanceState(outState)
//    }
//

    /**
     * To handle the back button, uncomment this and have your
     * [LayoutRunners][com.squareup.workflow.ui.LayoutRunner] use
     * [setBackHandler][com.squareup.workflow.ui.setBackHandler].
     */
//    override fun onBackPressed() {
//        if (!workflowOnBackPressed()) super.onBackPressed()
//    }
}
