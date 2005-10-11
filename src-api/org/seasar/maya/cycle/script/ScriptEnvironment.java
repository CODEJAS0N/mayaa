/*
 * Copyright 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.maya.cycle.script;

import java.util.Iterator;
import java.util.Map;

import org.seasar.maya.ParameterAware;
import org.seasar.maya.cycle.scope.AttributeScope;
import org.seasar.maya.source.SourceDescriptor;

/**
 * �X�N���v�g�̎��s���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ScriptEnvironment extends ParameterAware {
    
    /**
     * ���[�U�[��`�X�R�[�v�I�u�W�F�N�g��ǉ�����B
     * @param attrs ���[�U�[��`�X�R�[�v�B
     */
    void addAttributeScope(AttributeScope attrs);
    
    /**
     * ���[�U�[��`�X�R�[�v�I�u�W�F�N�g���C�e���[�g����B
     * @return �X�R�[�v�I�u�W�F�N�g�iAttributeScope�j�̃C�e���[�^�B
     */
    Iterator iterateAttributeScope();

    /**
     * �X�N���v�g������u���b�N�̊J���N�I�[�g�ɑO�u����鎯�ʕ�����̎擾�B
     * @return �J���N�I�[�g�O�u������B
     */
    String getBlockSign();
    
    /**
     * ����������R���p�C������B
     * @param script �X�N���v�g�B
     * @param sourceName �\�[�X�t�@�C�����B
     * @param lineno �J�n�s�ԍ��B
     * @return �R���p�C���ς݃X�N���v�g�I�u�W�F�N�g�B
     */
    CompiledScript compile(String script, String sourceName, int lineno);

    /**
     * �X�N���v�g�\�[�X�t�@�C����ǂݍ���ŃR���p�C������B
     * @param source �X�N���v�g�\�[�X�t�@�C���B
     * @param encoding �X�N���v�g�\�[�X�t�@�C���̃G���R�[�f�B���O�B
     * @return �R���p�C���ς݃X�N���v�g�I�u�W�F�N�g�B
     */
    CompiledScript compile(SourceDescriptor source, String encoding);
    
    /**
     * �e���v���[�g�`�掞�ɁA�v���Z�b�T�̃X�^�[�g�C�x���g�Ɠ������邽�߂̃��\�b�h�B
     * �J�����gServiceCycle�̃y�[�W�X�R�[�v������������B
     */
    void initScope();
    
    /**
     * �e���v���[�g�`�掞�ɁA�v���Z�b�T�̃X�^�[�g�C�x���g�Ɠ������邽�߂̃��\�b�h�B
     * �J�����gServiceCycle�̃y�[�W�X�R�[�v�ɁA�X�N���v�g�ϐ����v�b�V������B
     * @param variables �J�X�^���X�R�[�v�ϐ��B
     */
    void startScope(Map variables);
    
    /**
     * �e���v���[�g�`�掞�ɁA�v���Z�b�T�̃G���h�C�x���g�Ɠ������邽�߂̃��\�b�h�B
     * �J�����gServiceCycle�̃y�[�W�X�R�[�v����A�X�N���v�g�̃X�R�[�v�I�u�W�F�N�g
     * ���|�b�v����B
     */
    void endScope();
    
    /**
     * �X�N���v�g�����\���I�u�W�F�N�g����AJava�̃I�u�W�F�N�g�ɕϊ�����B
     * @param scriptObject �X�N���v�g�����\���I�u�W�F�N�g�B
     * @return Java�̃I�u�W�F�N�g�B
     */
    Object convertFromScriptObject(Object scriptObject);
    
}
