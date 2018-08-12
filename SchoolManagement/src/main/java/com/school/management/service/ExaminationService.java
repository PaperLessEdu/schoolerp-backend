package com.school.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.core.CustomException;
import com.school.management.dao.AcademicYearDaoImpl;
import com.school.management.dao.ExaminationDaoImpl;
import com.school.management.dao.ScheduleExamDaoImpl;
import com.school.management.dao.StandardDaoImpl;
import com.school.management.domain.AcademicYear;
import com.school.management.domain.Examination;
import com.school.management.domain.ScheduleExam;
import com.school.management.domain.Standard;
import com.school.management.domain.Subject;
import com.school.management.model.DistributionModel;
import com.school.management.model.ExamDistributionResponse;
import com.school.management.model.ExamScheduleModel;
import com.school.management.model.ExamScheduleResponseModel;
import com.school.management.model.ExaminationModel;
import com.school.management.model.ExaminationResponseModule;
import com.school.management.model.SmResponseStatus;

@Service
public class ExaminationService {

	@Autowired
	private ExaminationDaoImpl examinationDaoImpl;

	@Autowired
	private ScheduleExamDaoImpl scheduleExamDaoImpl;

	@Autowired
	private StandardDaoImpl standardDaoImpl;

	@Autowired
	private AcademicYearDaoImpl academicYearDaoImpl;
	public static final Logger logger = LoggerFactory.getLogger(ExaminationService.class);

	public SmResponseStatus addExamination(ExaminationModel examinationModel) {

		String message = null;

		Examination examination = wrapExmination(null, examinationModel);

		// TODO please verify student is present or not before saving same for
		// accadimic year id

		if (!academicYearDaoImpl.checkIfExists(examinationModel.getAcademicYearId())) {
			logger.info("Accadamic id not found");
			throw new CustomException("Accadamic year not Present please check with different id");

		}
		if (!standardDaoImpl.existsById(examinationModel.getStandardId())) {
			logger.info("standard id not found " + examinationModel.getStandardId());
			throw new CustomException("Standard ID not found please check standard id");
		}

		Examination resultExam = examinationDaoImpl.saveExamination(examination);

		List<ExamScheduleModel> examSechduleModuleList = examinationModel.getExamSchedule();

		for (ExamScheduleModel examScheduleModel : examSechduleModuleList) {
			ArrayList<DistributionModel> descriptionList = examScheduleModel.getDistribution();
			for (DistributionModel distributionModel : descriptionList) {

				distributionModel.getDate();

				ScheduleExam scheduleExam = new ScheduleExam();
				scheduleExam.setDate(distributionModel.getDate());
				scheduleExam.setPassingMarks(distributionModel.getPassingMarks());

				scheduleExam.setExamType(distributionModel.getExamType());
				scheduleExam.setOutOfMarks(distributionModel.getOutOfMarks());
				Subject subject_id = new Subject();
				subject_id.setSubject_id(examScheduleModel.getSubjectId());
				scheduleExam.setSubject_id(subject_id);
				scheduleExam.setExam_master_id(resultExam);
				scheduleExam.setStartTime(distributionModel.getStartTime());
				scheduleExam.setEndTime(distributionModel.getEndTime());
				scheduleExam.setScoreType(distributionModel.getScoreType());

				scheduleExamDaoImpl.saveScheduleExam(scheduleExam);

			}

		}
		message = String.format("Examination saved successfully with name [%s] and id [%s]", examination.getName(),
				resultExam.getExammasterid());

		return new SmResponseStatus(message);
	}

	public List<ExaminationResponseModule> getExaminationList() {

		List<Examination> examinationList = new ArrayList<>();

		List<ExaminationResponseModule> resultResponse = new ArrayList<>();

		try {
			examinationList = examinationDaoImpl.getExaminationList();

			for (Examination exam : examinationList) {
				ExaminationResponseModule examinationResponseModule = new ExaminationResponseModule();
				examinationResponseModule.setName(exam.getName());
				// TODO
				// ExamScheduleResponseModel examSchedule = null;

				List<ScheduleExam> scheduleExamList = scheduleExamDaoImpl.getScheduleByExamId(exam);

				List<ExamScheduleResponseModel> examSchedule = new ArrayList<>();

				Map<Long, List<ExamDistributionResponse>> resultMap = new HashMap<>();

				for (ScheduleExam scheduleExam : scheduleExamList) {

					if (resultMap.containsKey(scheduleExam.getSubject_id().getSubject_id())) {
						// key present means need ot reaad first value and then
						// append the value

						List<ExamDistributionResponse> orgDistResponse = resultMap
								.get(scheduleExam.getSubject_id().getSubject_id());

						ExamDistributionResponse examDistributionResponse = new ExamDistributionResponse();
						examDistributionResponse.setDate(scheduleExam.getDate());
						examDistributionResponse.setEndTime(scheduleExam.getEndTime());
						examDistributionResponse.setStartTime(scheduleExam.getStartTime());
						examDistributionResponse.setExamType(scheduleExam.getExamType());
						examDistributionResponse.setMarksOutOf(scheduleExam.getOutOfMarks());
						examDistributionResponse.setPassingMarks(scheduleExam.getPassingMarks());
						examDistributionResponse.setScoreType(scheduleExam.getScoreType());
						orgDistResponse.add(examDistributionResponse);
					} else {

						List<ExamDistributionResponse> distribution = new ArrayList<>();
						// todo process
						ExamDistributionResponse examDistributionResponse = new ExamDistributionResponse();
						examDistributionResponse.setDate(scheduleExam.getDate());
						examDistributionResponse.setEndTime(scheduleExam.getEndTime());
						examDistributionResponse.setStartTime(scheduleExam.getStartTime());						
						examDistributionResponse.setExamType(scheduleExam.getExamType());
						examDistributionResponse.setMarksOutOf(scheduleExam.getOutOfMarks());
						examDistributionResponse.setPassingMarks(scheduleExam.getPassingMarks());
						examDistributionResponse.setScoreType(scheduleExam.getScoreType());
						distribution.add(examDistributionResponse);
						resultMap.put(scheduleExam.getSubject_id().getSubject_id(), distribution);
					}

					// TODO collcet grouo by subject id

					// call exam id and subnect id

					/*
					 * List<ScheduleExam> tempscheduleExamList =
					 * scheduleExamDaoImpl.getScheduleByExamIdSubjectId(exam,
					 * scheduleExam.getSubject_id());
					 * List<ExamDistributionResponse> distribution = new
					 * ArrayList<>();
					 * 
					 * for (ScheduleExam tempscheduleExam :
					 * tempscheduleExamList) { ExamDistributionResponse
					 * examDistributionResponse = new
					 * ExamDistributionResponse();
					 * examDistributionResponse.setDate(tempscheduleExam.getDate
					 * ());
					 * examDistributionResponse.setEndTime(tempscheduleExam.
					 * getEndTime());
					 * examDistributionResponse.setExamType(tempscheduleExam.
					 * getExamType());
					 * examDistributionResponse.setMarksOutOf(tempscheduleExam.
					 * getOutOfMarks());
					 * examDistributionResponse.setPassingMarks(tempscheduleExam
					 * .getPassingMarks());
					 * examDistributionResponse.setScoreType(tempscheduleExam.
					 * getScoreType());
					 * 
					 * distribution.add(examDistributionResponse);
					 * 
					 * }
					 */

					// examScheduleResponseModule.setDistribution(distribution);

					// todo group by subject id can query form db its easy way.
				}
				ExamScheduleResponseModel examScheduleResponseModule = new ExamScheduleResponseModel();

				for (Map.Entry<Long, List<ExamDistributionResponse>> entry : resultMap.entrySet()) {
					Long key = entry.getKey();
					List<ExamDistributionResponse> value = entry.getValue();
					examScheduleResponseModule.setSubjectId(key);
					examScheduleResponseModule.setDistribution(value);
				}
				examSchedule.add(examScheduleResponseModule);

				examinationResponseModule.setExamSchedule(examSchedule);

				resultResponse.add(examinationResponseModule);
			}

		} catch (Exception e) {
			String error = String.format("Error occured while fetching examination List");
			logger.error(error, e);
			throw e;
		}
		return resultResponse;

	}

	private Examination wrapExmination(Long exam_master_id, ExaminationModel examinationModel) {

		Examination examination = new Examination();

		if (exam_master_id != null) {

			examination.setExammasterid(examinationModel.getExam_master_id());

		}
		AcademicYear y = new AcademicYear();
		y.setAcademicYearId(examinationModel.getAcademicYearId());
		examination.setAcademicyear(y);
		examination.setName(examinationModel.getName());
		Standard s = new Standard();
		s.setStandard_id(examinationModel.getStandardId());
		examination.setStandard(s);

		return examination;
	}

}
