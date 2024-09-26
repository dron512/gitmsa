<template>
  <div>
    <!-- TipTap Toolbar 버튼 -->
    <div class="flex space-x-2 mb-4">
      <button @click="toggleBold" class="px-4 py-2 border">Bold</button>
      <button @click="toggleItalic" class="px-4 py-2 border">Italic</button>
    </div>

    <!-- TipTap Editor Content -->
    <EditorContent :editor="editor" class="border p-4" />
  </div>
</template>

<script setup>
import { onBeforeUnmount } from 'vue'
import { EditorContent, useEditor } from '@tiptap/vue-3'
import StarterKit from '@tiptap/starter-kit'

// TipTap 에디터 인스턴스 생성
const editor = useEditor({
  extensions: [StarterKit],
  content: '<p>Hello World! This is TipTap!</p>',
})

// 에디터에서 bold 토글
const toggleBold = () => {
  editor.chain().focus().toggleBold().run()
}

// 에디터에서 italic 토글
const toggleItalic = () => {
  editor.chain().focus().toggleItalic().run()
}

// 컴포넌트 언마운트 시 TipTap 에디터 인스턴스를 해제
onBeforeUnmount(() => {
  editor.destroy()
})
</script>
