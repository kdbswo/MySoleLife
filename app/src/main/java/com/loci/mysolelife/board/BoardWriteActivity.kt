package com.loci.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.loci.mysolelife.R
import com.loci.mysolelife.contentsList.BookmarkModel
import com.loci.mysolelife.databinding.ActivityBoardWriteBinding
import com.loci.mysolelife.utils.FBAuth
import com.loci.mysolelife.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener {
            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()
            Log.d(TAG, title)
            Log.d(TAG, content)

            FBRef.boardRef
                .push()
                .setValue(BoardModel(title, content, uid, time))

            Toast.makeText(this,"게시글 입력 완료", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}